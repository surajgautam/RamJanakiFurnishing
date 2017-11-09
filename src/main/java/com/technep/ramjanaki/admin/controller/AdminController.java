package com.technep.ramjanaki.admin.controller;

import com.technep.ramjanaki.admin.model.Country;
import com.technep.ramjanaki.admin.model.CountryDTO;
import org.dozer.DozerBeanMapper;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by surajgautam on 7/9/17.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private SessionFactory sessionFactory;


    String apikey="live_1bd88e456f4d106a1f59b7ae84e3b4b7eda2aa6d";

    @RequestMapping(value = "/manage")
    public ModelAndView returnAdmin(){
        ModelAndView modelAndView = new ModelAndView("admin/admin");
        modelAndView.addObject("title","Admin Panel");
        return  modelAndView;
    }


    @RequestMapping(value = "/get/countries")
    @Transactional
    public String returnAPIValue(){



        for(int i = 1; i<=6; i++){
            CountryDTO countryWithAPI = getCountryWithAPI(i);
            List<Country> results = countryWithAPI.getResults();
            for(Country country:results){
                sessionFactory.getCurrentSession().save(country);
            }
        }
        return "success";
    }

    public  CountryDTO getCountryWithAPI(int i){

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("X-Application-Key", apikey);

        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        String URL = "https://rest.gadventures.com/countries/?page=" + i;
        ResponseEntity<Object> exchange = restTemplate.exchange(URL, HttpMethod.GET, httpEntity, Object.class);
        Object body = exchange.getBody();

        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        CountryDTO countryDTO = dozerBeanMapper.map(body,CountryDTO.class);

        return countryDTO;

    }
}
