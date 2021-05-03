package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.*;
@RestController
public class MovieRestController {
   @Autowired
   private MovieDAO dao;
}
