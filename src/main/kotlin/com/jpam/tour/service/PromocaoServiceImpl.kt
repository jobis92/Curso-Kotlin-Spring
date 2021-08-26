package com.jpam.tour.service

import com.jpam.tour.model.Promocao
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class PromocaoServiceImpl : PromocaoService {
    companion object {
        val initialPromocoes = arrayOf(
            Promocao(1, "Maravilhosa viagem a Cancun", "Cancun", true, 7, 4200.99),
            Promocao(2, "Viagem radical com rapel e escalada", "Nova Zelandia", false, 12, 12000.0),
            Promocao(3, "Viagem espiritual", "Thailandia", false, 17, 15000.00),
            Promocao(4, "Viagem com a familia", "Gramado", false, 5, 3500.33)

        )
    }

    var promocoes = ConcurrentHashMap<Long, Promocao>(initialPromocoes.associateBy(Promocao::id))


    override fun getById(id: Long): Promocao? {
        return promocoes[id]
    }

    override fun create(promocao: Promocao) {
        promocoes[promocao.id] = promocao
    }

    override fun delete(id: Long) {
        promocoes.remove(id)
    }

    override fun update(id: Long, promocao: Promocao) {
        delete(id)
        promocoes[id] = promocao
    }

    override fun searchByLocal(localFilter: String): List<Promocao> =
        promocoes.filter {
            it.value.local.contains(localFilter, true)
        }.map(Map.Entry<Long, Promocao>::value).toList()

}