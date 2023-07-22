package io.reservation.reservation.controller;

import io.reservation.reservation.domain.User;
import io.reservation.reservation.model.ReservationDTO;
import io.reservation.reservation.repos.UserRepository;
import io.reservation.reservation.service.ReservationService;
import io.reservation.reservation.util.CustomCollectors;
import io.reservation.reservation.util.WebUtils;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final UserRepository userRepository;

    public ReservationController(final ReservationService reservationService,
            final UserRepository userRepository) {
        this.reservationService = reservationService;
        this.userRepository = userRepository;
    }

    @ModelAttribute
    public void prepareContext(final Model model) {
        model.addAttribute("userValues", userRepository.findAll(Sort.by("id"))
                .stream()
                .collect(CustomCollectors.toSortedMap(User::getId, User::getId)));
    }

    @GetMapping
    public String list(final Model model) {
        model.addAttribute("reservations", reservationService.findAll());
        return "reservation/list";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("reservation") final ReservationDTO reservationDTO) {
        return "reservation/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("reservation") @Valid final ReservationDTO reservationDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "reservation/add";
        }
        reservationService.create(reservationDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("reservation.create.success"));
        return "redirect:/reservations";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable final Long id, final Model model) {
        model.addAttribute("reservation", reservationService.get(id));
        return "reservation/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable final Long id,
            @ModelAttribute("reservation") @Valid final ReservationDTO reservationDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "reservation/edit";
        }
        reservationService.update(id, reservationDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("reservation.update.success"));
        return "redirect:/reservations";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable final Long id, final RedirectAttributes redirectAttributes) {
        reservationService.delete(id);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("reservation.delete.success"));
        return "redirect:/reservations";
    }

}
