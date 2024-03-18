package com.std.ec.service.impl;

import com.std.ec.model.dao.ClienteDao;
import com.std.ec.model.dto.ClienteDTO;
import com.std.ec.model.entity.Cliente;
import com.std.ec.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteImplService implements IClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    public List<Cliente> listAll(){
        return (List) clienteDao.findAll();
    }

    @Transactional
    @Override
    public Cliente save(ClienteDTO clienteDTO) {
        Cliente cliente = Cliente.builder()
                .IdCliente(clienteDTO.getIdCliente())
                .nombre(clienteDTO.getNombre())
                .apellido(clienteDTO.getApellido())
                .correo(clienteDTO.getCorreo())
                .fechaRegistro(clienteDTO.getFechaRegistro())
                .build();
        return clienteDao.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findByid(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    public boolean existsById(Integer id) {
        return clienteDao.existsById(id);
    }


}
