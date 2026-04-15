package com.ersin.restaurantreservation.controller;

import com.ersin.restaurantreservation.entity.Reservation;
import com.ersin.restaurantreservation.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/")
    public String showPage(Model model) {
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "index";
    }

    @PostMapping("/save")
    public String saveReservation(@ModelAttribute Reservation reservation) {
        reservationService.saveReservation(reservation);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return "redirect:/";
    }
}