package com.example.nytimesmostpopulararticlesapplication

import com.example.nytimesmostpopulararticlesapplication.local.Articles
import com.example.nytimesmostpopulararticlesapplication.local.MediaMetadata
import com.example.nytimesmostpopulararticlesapplication.remote.ArticleResponse
import com.example.nytimesmostpopulararticlesapplication.remote.Media


fun mapToDomain( articleResponse: ArticleResponse) : List<Articles>{
    return articleResponse.results.map {
        Articles(
            id = it.id,
            abstractArticle = it.abstractArticle,
            adxKeywords = it.adxKeywords,
            assetId = it.assetId,
            byline = it.byline,
            column = it.column,
            desFacet = it.desFacet,
            etaId = it.etaId,
            geoFacet = it.geoFacet,
            media = mapToMedia(it.media),
            nyTDsection = it.nyTDsection,
            orgFacet = it.orgFacet,
            perFacet = it.perFacet,
            publishedDate = it.publishedDate,
            section = it.section,
            source = it.source,
            subsection = it.subsection,
            title = it.title,
            type = it.type,
            updated = it.updated,
            uri = it.uri,
            url = it.url
        )
    }
}

fun mapToMedia(responseMedia: List<Media>) : List<com.example.nytimesmostpopulararticlesapplication.local.Media>{
    return responseMedia.map {
       com.example.nytimesmostpopulararticlesapplication.local.Media(
            approvedForSyndication = it.approvedForSyndication,
            caption = it.caption,
            copyRight = it.copyRight,
            mediaMetaData = mapToMediaMetaData(it.mediaMetaData),
            subType = it.subType,
            type = it.type
        )
    }
}

fun mapToMediaMetaData(responseMetaData: List<com.example.nytimesmostpopulararticlesapplication.remote.MediaMetadata>) : List<MediaMetadata>{
    return responseMetaData.map {
        MediaMetadata(
            format = it.format,
            height = it.height,
            url = it.url,
            width = it.width
        )
    }
}