package com.arakviel.eventlistenerdemo.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ValidationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidationExceptions(MethodArgumentNotValidException ex, Model model) {
        BindingResult bindingResult = ex.getBindingResult();
        var errors = bindingResult.getFieldErrors().stream()
              .map(FieldError::getDefaultMessage)
              .toList();

        // Додаємо помилки до моделі, щоб їх можна було відобразити в JTE
        model.addAttribute("validationErrors", errors);

        // Повертаємо ту саму сторінку, на якій була помилка (наприклад, "signup.jte")
        return "users/signup";  // Повертаємо назву оригінальної сторінки
    }
}
