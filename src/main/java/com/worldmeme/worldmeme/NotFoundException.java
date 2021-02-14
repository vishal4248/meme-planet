package com.worldmeme.worldmeme;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Meme Not Found")
public class NotFoundException  extends RuntimeException{

}
