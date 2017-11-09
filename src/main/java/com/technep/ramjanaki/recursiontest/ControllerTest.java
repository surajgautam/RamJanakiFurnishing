package com.technep.ramjanaki.recursiontest;/*
author: surajgautam
email: teamwarrior200@gmail.com
*/

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ControllerTest {

    int flagCount = 0;


    @GetMapping(value = "/test/recursion")
    public List<LedgerTreeDto> returnLedgerTreeDto() {

        List<LedgerTreeDto> finalList = new ArrayList<LedgerTreeDto>();
        List<LedgerTreeDto> children = new ArrayList<LedgerTreeDto>();
        List<LedgerTreeDto> children1 = new ArrayList<LedgerTreeDto>();
        List<LedgerTreeDto> children2 = new ArrayList<LedgerTreeDto>();
        List<LedgerTreeDto> children3 = new ArrayList<LedgerTreeDto>();


        LedgerTreeDto chilDto = new LedgerTreeDto();
        chilDto.setId(11);
        chilDto.setLevel("level2");
        chilDto.setName("Current Assets");

        LedgerTreeDto chilDto1 = new LedgerTreeDto();
        chilDto1.setId(11);
        chilDto1.setLevel("level2");
        chilDto1.setName("Non-Current Assets");

        LedgerTreeDto childForFixed = new LedgerTreeDto();
        childForFixed.setId(111);
        childForFixed.setName("Machine");
        childForFixed.setLevel("level3");

        LedgerTreeDto childForFixed1 = new LedgerTreeDto();
        childForFixed1.setId(111);
        childForFixed1.setName("land");
        childForFixed1.setLevel("level3");


        LedgerTreeDto childForFixed2 = new LedgerTreeDto();
        childForFixed2.setId(111);
        childForFixed2.setName("computer");
        childForFixed2.setLevel("level3");


        LedgerTreeDto childForFixed3 = new LedgerTreeDto();
        childForFixed3.setId(111);
        childForFixed3.setName("building    ");
        childForFixed3.setLevel("level3");


        children2.add(childForFixed1);
        children2.add(childForFixed2);
        children2.add(childForFixed3);


        LedgerTreeDto chilDto2 = new LedgerTreeDto();
        chilDto2.setId(11);
        chilDto2.setLevel("level2");
        chilDto2.setName("Fixed Assets");
        chilDto2.setChildren(children2);

        LedgerTreeDto chilDto3 = new LedgerTreeDto();
        chilDto3.setId(11);
        chilDto3.setLevel("level2");
        chilDto3.setName("Investment Assets");

        children.add(chilDto);
        children.add(chilDto1);
        children.add(chilDto2);
        children.add(chilDto3);

        LedgerTreeDto dto = new LedgerTreeDto();
        dto.setId(1);
        dto.setLevel("level1");
        dto.setChildren(children);
        dto.setName("Assets");

        finalList.add(dto);

        LedgerTreeDto liabilities1 = new LedgerTreeDto();
        liabilities1.setId(11);
        liabilities1.setLevel("level2");
        liabilities1.setName("ac payable");

        LedgerTreeDto liabilities2 = new LedgerTreeDto();
        liabilities2.setId(11);
        liabilities2.setLevel("level2");
        liabilities2.setName("loan");

        LedgerTreeDto liabilities3 = new LedgerTreeDto();
        liabilities3.setId(11);
        liabilities3.setLevel("level2");
        liabilities3.setName("creditors");


        LedgerTreeDto dtoForOs = new LedgerTreeDto();
        dtoForOs.setLevel("level3");
        dtoForOs.setId(222);
        dtoForOs.setName("Os salary");

        LedgerTreeDto dtoForOs1 = new LedgerTreeDto();
        dtoForOs1.setLevel("level3");
        dtoForOs1.setId(222);
        dtoForOs1.setName("Os rent");

        LedgerTreeDto dtoForOs2 = new LedgerTreeDto();
        dtoForOs2.setLevel("level3");
        dtoForOs2.setId(222);
        dtoForOs2.setName("Os wages");

        LedgerTreeDto dtoForOs3 = new LedgerTreeDto();
        dtoForOs3.setLevel("level3");
        dtoForOs3.setId(222);
        dtoForOs3.setName("Os allowance");


        children3.add(dtoForOs);
        children3.add(dtoForOs1);
        children3.add(dtoForOs2);
        children3.add(dtoForOs3);


        LedgerTreeDto liabilities4 = new LedgerTreeDto();
        liabilities4.setId(11);
        liabilities4.setLevel("level2");
        liabilities4.setName("outstanding wages");
        liabilities4.setChildren(children3);


        children1.add(liabilities1);
        children1.add(liabilities2);
        children1.add(liabilities3);
        children1.add(liabilities4);

        LedgerTreeDto dto2 = new LedgerTreeDto();
        dto2.setId(1);
        dto2.setLevel("level1");
        dto2.setChildren(children1);
        dto2.setName("Liabilities");


        finalList.add(dto2);

        return returnCheckRecursion(finalList);



    }

    public List<LedgerTreeDto> returnCheckRecursion(List<LedgerTreeDto> finalList) {
        /*RestTemplate restTemplate = new RestTemplate();
        String URL = "http://localhost:8080/ecommerce/test/recursion";
        ResponseEntity<LedgerTreeDto[]> entity = restTemplate.getForEntity(URL, LedgerTreeDto[].class);
        List<LedgerTreeDto> finalList = Arrays.asList(entity.getBody());*/


        if(finalList==null){
            return new ArrayList<LedgerTreeDto>();
        }


        List<LedgerTreeDto> newFinalList = null;


        //FINAL
        if(flagCount==0){
         newFinalList = new ArrayList<LedgerTreeDto>();
        }
        String levelCheck = "level3";



        //logic starts
        for (LedgerTreeDto ledgerTreeDto : finalList) {

            //check if level matches
            if (ledgerTreeDto.getLevel().equalsIgnoreCase(levelCheck)) {
                ledgerTreeDto.setChildren(null);
                newFinalList.add(ledgerTreeDto);
            }
            //if item is added in the list

            if (newFinalList.size() != 0 && flagCount==0) {

            }else{
                List<LedgerTreeDto> children = ledgerTreeDto.getChildren();
                for(int i = 0;i<children.size();i++){
                    if(children.get(i).getLevel().equalsIgnoreCase(levelCheck)){
                        newFinalList.add(children.get(i));
                        flagCount++;
                    }else{
                        flagCount++;
                        returnCheckRecursion(children.get(i).getChildren());
                        break;
                    }
                }
            }

        }


        return newFinalList;
    }




}
