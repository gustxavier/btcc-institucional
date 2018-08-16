//package com.btcc.institucional.web.controller;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.multipart.MultipartException;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    //https://jira.spring.io/browse/SPR-14651
//    //Spring 4.3.5 supports RedirectAttributes
//    @ExceptionHandler(MultipartException.class)
//    public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
//
//        redirectAttributes.addFlashAttribute("warning", e.getCause().getMessage());
//        return "redirect:/admin/noticias/upload-imagem";
//
//    }
//
//    /* Spring < 4.3.5
//	@ExceptionHandler(MultipartException.class)
//    public String handleError2(MultipartException e) {
//
//        return "redirect:/errorPage";
//
//    }*/
//
//}
