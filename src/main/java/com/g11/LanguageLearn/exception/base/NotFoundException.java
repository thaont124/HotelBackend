package com.g11.LanguageLearn.exception.base;


import static com.g11.LanguageLearn.constants.PassbookManagerConstants.StatusException.*;

public class NotFoundException extends BaseException {
  public NotFoundException(String id, String objectName) {
    setCode("com.ncsgroup.profiling.exception.base.NotFoundException");
    setStatus(NOT_FOUND);
    addParam("id", id);
    addParam("objectName", objectName);
  }

  public NotFoundException() {
    setCode("com.ncsgroup.profiling.exception.base.NotFoundException");
    setStatus(NOT_FOUND);
  }
}
