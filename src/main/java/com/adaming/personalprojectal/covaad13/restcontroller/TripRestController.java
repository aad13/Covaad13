package com.adaming.personalprojectal.covaad13.restcontroller;

        import com.adaming.personalprojectal.covaad13.service.TripService;
        import com.adaming.personalprojectal.covaad13.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covaad/webapi")
public class TripRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private TripService tripService;
}
