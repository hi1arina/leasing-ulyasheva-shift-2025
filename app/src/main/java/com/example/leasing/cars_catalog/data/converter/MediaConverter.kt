package com.example.leasing.cars_catalog.data.converter

import com.example.leasing.cars_catalog.data.model.MediaModel
import com.example.leasing.cars_catalog.domain.entity.Media

object MediaConverter {

    fun convert (media: MediaModel) : Media =
        Media (
            url = media.url,
            isCover = media.isCover
        )

}