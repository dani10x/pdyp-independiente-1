package com.example.bpm.service;

import com.example.bpm.model.Solicitud;
import com.example.bpm.repository.SolicitudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;

    public List<Solicitud> obtenerTodas() {
        return solicitudRepository.findAll();
    }

    public Solicitud crearSolicitud(String descripcion) {
        Solicitud solicitud = new Solicitud();
        solicitud.setDescripcion(descripcion);
        solicitud.setEstado("Pendiente");
        return solicitudRepository.save(solicitud);
    }

    public Solicitud aprobarSolicitud(Long id) {
        Solicitud solicitud = solicitudRepository.findById(id).orElseThrow();
        solicitud.setEstado("Aprobada");
        return solicitudRepository.save(solicitud);
    }

    public Solicitud rechazarSolicitud(Long id) {
        Solicitud solicitud = solicitudRepository.findById(id).orElseThrow();
        solicitud.setEstado("Rechazada");
        return solicitudRepository.save(solicitud);
    }
}
