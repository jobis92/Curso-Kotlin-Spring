package com.jpam.tour.service

import com.jpam.tour.model.Promocao

interface PromocaoService {

    fun getById(id: Long): Promocao?

    fun create(promocao: Promocao)

    fun delete(id: Long)

    fun update(id: Long, promocao: Promocao)

    fun searchByLocal(localFilter: String): List<Promocao>

}
