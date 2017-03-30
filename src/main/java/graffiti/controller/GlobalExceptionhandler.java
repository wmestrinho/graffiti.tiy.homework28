package graffiti.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by WagnerMestrinho on 3/22/17.
 */
@ControllerAdvice
public class GlobalExceptionhandler {


        //Spring 4.3.5 supports RedirectAttributes
        @ExceptionHandler(MultipartException.class)
        public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {

            redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
            return "redirect:/uploadStatus";

        }

    /* Spring < 4.3.5
	@ExceptionHandler(MultipartException.class)
    public String handleError2(MultipartException e) {

        return "redirect:/errorPage";

    }*/

    }
