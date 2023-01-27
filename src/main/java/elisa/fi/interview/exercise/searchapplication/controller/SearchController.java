package elisa.fi.interview.exercise.searchapplication.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import elisa.fi.interview.exercise.searchapplication.exception.SearchException;
import elisa.fi.interview.exercise.searchapplication.service.SearchService;
import elisa.fi.interview.exercise.searchapplication.util.InputValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

@RestController()
@RequestMapping("/search")
@Tag(name = "SearchController")
public class SearchController {

  private final SearchService searchService;

  public SearchController(SearchService searchService) {
    this.searchService = searchService;
  }

  @PostMapping(
      path = "/useStreams",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Search using Streams")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Search done successfully"),
          @ApiResponse(responseCode = "400", description = "Error in search"),
  })

  public ResponseEntity<?> searchSmallestIntUsingStreams(@Valid @RequestBody int[] array)  {
   try{
     if(InputValidator.isValidInput(array)){
       int result = searchService.findMinPositiveValueUsingStreamAPI(array);
        return new ResponseEntity(result, HttpStatus.valueOf(200));}
     else{
       throw new SearchException(Arrays.toString(array));
     }
   } catch (SearchException e) {
     return new ResponseEntity("Invalid input!!", HttpStatus.valueOf(400));
   }
  }


  @PostMapping(
      path = "/useSort",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Search using Sort")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Search done successfully"),
          @ApiResponse(responseCode = "400", description = "Error in search"),
  })
  public ResponseEntity<?> searchSmallestIntUsingSort(@RequestBody int[] array) throws UnsupportedEncodingException{
    try{
      if(InputValidator.isValidInput(array)){
        int result = searchService.findMinPositiveValueUsingSortMethod(array);
        return new ResponseEntity(result, HttpStatus.valueOf(200));}
      else{
        throw new SearchException(Arrays.toString(array));
      }
    }    catch (SearchException e) {
      return new ResponseEntity("Invalid input!!", HttpStatus.valueOf(400));
    }
  }

  @PostMapping(
      path = "/useBruteForceAlgo",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Search using BruteForceAlgo")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Search done successfully"),
          @ApiResponse(responseCode = "400", description = "Error in search"),
  })
  public ResponseEntity<?> searchSmallestIntUsingBruteForce(@RequestBody int[] array) throws UnsupportedEncodingException{
    try{
      if(InputValidator.isValidInput(array)){
        int result = searchService.findMinPositiveValueUsingBruteForce(array);
        return new ResponseEntity(result, HttpStatus.valueOf(200));}
      else{
        throw new SearchException(Arrays.toString(array));
      }
    }    catch (SearchException e) {
      return new ResponseEntity("Invalid input!!", HttpStatus.valueOf(400));
    }
  }

  @PostMapping(
      path = "/useHashSet",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Search using Hashset")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Search done successfully"),
          @ApiResponse(responseCode = "400", description = "Error in search"),
  })
  public ResponseEntity<?> searchSmallestIntUsingHashSet(@RequestBody int[] array) throws UnsupportedEncodingException{
    try{
      if(InputValidator.isValidInput(array)){
        int result = searchService.findMinPositiveValueUsingHashSet(array);
        return new ResponseEntity(result, HttpStatus.valueOf(200));}
      else{
        throw new SearchException(Arrays.toString(array));
      }
    }    catch (SearchException e) {
      return new ResponseEntity("Invalid input!!", HttpStatus.valueOf(400));
    }
  }

  @PostMapping(
      path = "/useMinHeap",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Search using MinHeap")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Search done successfully"),
          @ApiResponse(responseCode = "400", description = "Error in search"),
  })
  public ResponseEntity<?> searchSmallestIntUsingMinHeap(@RequestBody int[] array) throws UnsupportedEncodingException{
    try{
      if(InputValidator.isValidInput(array)){
        int result = searchService.findMinPositiveValueUsingMinHeap(array);
        return new ResponseEntity(result, HttpStatus.valueOf(200));}
      else{
        throw new SearchException(Arrays.toString(array));
      }
    }    catch (SearchException e) {
      return new ResponseEntity("Invalid input!!", HttpStatus.valueOf(400));
    }
  }


}
