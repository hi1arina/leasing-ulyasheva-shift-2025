package com.example.leasing.cars_catalog.data.converter

import com.example.leasing.cars_catalog.data.model.MetaModel
import com.example.leasing.cars_catalog.domain.entity.Meta

object MetaConverter {

    fun convert (meta: MetaModel) : Meta =
        Meta (
            total = meta.total,
            page = meta.page,
            limit = meta.limit,
            totalPages = meta.totalPages
        )

}