package com.std.ec.service;

import com.std.ec.model.dto.ClienteDTO;
import com.std.ec.model.entity.Cliente;

import java.util.List;

public interface IClienteService {

    List<Cliente> listAll();
    Cliente save(ClienteDTO clienteDTO);
    Cliente findByid(Integer id);
    void delete(Cliente cliente);
    boolean existsById(Integer id);
}
