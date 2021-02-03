package com.ssdev.smartinv.controller.customer;

import com.ssdev.smartinv.dto.CustomerDTO;
import com.ssdev.smartinv.model.common.Country;
import com.ssdev.smartinv.model.customer.Customer;
import com.ssdev.smartinv.service.customer.CustomerService;
import com.ssdev.smartinv.util.common.CommonUtil;
import com.ssdev.smartinv.util.common.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(@ModelAttribute("fieldNames") ArrayList<String> fieldNames, Model model) {
        if(!fieldNames.isEmpty()) {
            model.addAttribute("fields", fieldNames);
        }
        Map<String, String> selectItems = CommonUtil.prepareMapForSelect(Country.class);
        model.addAttribute("customer", new CustomerDTO());
        model.addAttribute("selectItems", selectItems);
        return "customer/create";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam(name = "id") String id, Model model) {
        Map<String, String> selectItems = CommonUtil.prepareMapForSelect(Country.class);
        Customer customer = customerService.get(Long.parseLong(id));
        CustomerDTO customerDTO = customerService.prepareDTO(customer);
        model.addAttribute("customer", customerDTO);
        model.addAttribute("selectItems", selectItems);
        return "customer/create";
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String details(@RequestParam(name = "id", required = false) String id, Model model) {
        if(id != null) {
            Customer customer = customerService.get(Long.parseLong(id));
            model.addAttribute("customer", customer);
        }
        return "customer/details";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Customer> customerList = customerService.getALL();
        model.addAttribute("itemList", customerList);
        return "customer/list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RedirectView save(@Valid @ModelAttribute("customer") CustomerDTO customer, BindingResult result, RedirectAttributes attributes, HttpServletRequest request) {
        List<String> errorFields = RequestUtil.getFieldNamesFromBindingResult(result);
        if(errorFields.isEmpty()) {
            Customer newCustomer = customerService.save(customer);
            attributes.addAttribute("id", newCustomer.getId());
            return new RedirectView(request.getContextPath() + "/customer/details");
        }
        attributes.addFlashAttribute("fieldNames", errorFields);
        return new RedirectView(request.getContextPath() + "/customer/create");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public RedirectView delete(@RequestParam(name = "id") String id, RedirectAttributes attributes, HttpServletRequest request) {
        customerService.delete(customerService.get(Long.parseLong(id)));
        attributes.addFlashAttribute("message", "deleted successfully");
        return new RedirectView(request.getContextPath() + "/customer/list");
    }
}
