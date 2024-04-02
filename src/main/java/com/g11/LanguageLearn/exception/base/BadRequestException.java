package com.g11.LanguageLearn.exception.base;


import static com.g11.LanguageLearn.constants.PassbookManagerConstants.StatusException.*;

public class BadRequestException extends BaseException {
  public BadRequestException() {
    setCode("com.ncsgroup.profiling.exception.base.BadRequestException");
    setStatus(BAD_REQUEST);
  }
}
