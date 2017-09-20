package com.technep.ramjanaki.payment.controller;

import com.technep.ramjanaki.dto.AcceptPayment;
import com.technep.ramjanaki.product.model.Product;
import com.technep.ramjanaki.product.service.ProductService;
import com.technep.ramjanaki.sales.model.SalesModel;
import com.technep.ramjanaki.sales.service.SalesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class PaymentController {

    @Autowired private SalesService salesService;

    @Autowired private HttpSession httpSession;

    @Autowired private ProductService productService;

    private SalesModel salesModel = null;
    @RequestMapping(value = "/payment")
    public ModelAndView returnPayment(@RequestParam("action")String action){

        ModelAndView mv = new ModelAndView("index");
        if(action!=null){
            if(StringUtils.equals(action,"su")){
                salesModel.setUserId(Integer.parseInt(httpSession.getAttribute("id").toString()));
                salesService.saveSales(salesModel);
                mv.addObject("payment",true);
                mv.addObject("message","Successfully paid");

                Product productByProductId = productService.getProductByProductId(salesModel.getProductId());
                productByProductId.setQuantity(productByProductId.getQuantity()-1);
                productService.updateProduct(productByProductId);

                return mv;
            }
            if(StringUtils.equals(action,"fu")){
                mv.addObject("payment",true);
                mv.addObject("message","Payment Unsuccessful due to several reasons");
            }
        }
        return mv;

    }

    @RequestMapping(value = "/accept/payment",method = RequestMethod.POST)
    public void acceptPayment(@RequestBody AcceptPayment acceptPayment){
        salesModel = new SalesModel();
        salesModel.setProductId(acceptPayment.getId());
        salesModel.setPrice(acceptPayment.getPrice());
        salesModel.setQuantity(1);
        salesModel.setTaxAmount(acceptPayment.getTaxamount());
        salesModel.setTotalPrice(acceptPayment.getTotalprice());
        System.out.println(acceptPayment.toString());
        System.out.println("hittedddddddddddddddddddddddddddddddddddddd");

    }


}
