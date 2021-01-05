package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.exceptions.BadTextTransformationException;
import pl.put.poznan.transformer.logic.TextTransformer;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.Arrays;

@RestController
@RequestMapping("/{text}")
public class TextTransformerController {
    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> get(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="nochange") String[] transforms) {
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));
        try {
            TextTransformer transformer = new TextTransformer(transforms);
            return new ResponseEntity<>(transformer.transform(text), HttpStatus.OK);
        }
        catch(BadTextTransformationException e){
            return new ResponseEntity<>("Transformation error!", HttpStatus.BAD_REQUEST);
        }
    }





}


