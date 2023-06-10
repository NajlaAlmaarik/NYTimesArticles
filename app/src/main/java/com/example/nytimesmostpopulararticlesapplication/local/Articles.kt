package com.example.nytimesmostpopulararticlesapplication.local


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.nytimesmostpopulararticlesapplication.fromList
import com.example.nytimesmostpopulararticlesapplication.toList
import kotlinx.parcelize.Parcelize


@Entity(tableName = "articles_table")
@Parcelize
data class Articles(
    @PrimaryKey
    var id: Long? = 0,
    var abstractArticle: String? = null,
    var adxKeywords: String? = null,
    var assetId: Long? =0,
    var byline: String? = null,
    var column: String? = null,
    var desFacet: List<String>?=null,
    var etaId: Int? =0,
    var geoFacet: List<String>?=null,
    var media: List<Media>?=null,
    var nyTDsection: String?=null,
    var orgFacet: List<String>?=null,
    var perFacet: List<String>?=null,
    var publishedDate: String?=null,
    var section: String?=null,
    var source: String?=null,
    var subsection: String?=null,
    var title: String?=null,
    var type: String?=null,
    var updated: String?=null,
    var uri: String?=null,
    var url: String?=null,
    var abstract: String?=null,
):Parcelable


@Parcelize
data class Media(
    var approvedForSyndication: Int?=0,
    var caption: String?=null,
    var copyRight: String?=null,
    var mediaMetaData: List<MediaMetadata>?=null,
    var subType: String?=null,
    var type: String?=null
):Parcelable

@Parcelize
data class MediaMetadata(
    var format: String?=null,
    var height: Int?=0,
    var url: String?=null,
    var width: Int?=0
):Parcelable

class CachedStringConverter{
    @TypeConverter
    fun fromItem(value : List<String>): String = fromList(value)

    @TypeConverter
    fun toItem(value : String) : List<String> = toList(value)
}

class CachedMediaConverter{
    @TypeConverter
    fun fromItem(value : List<Media>): String = fromList(value)

    @TypeConverter
    fun toItem(value : String) : List<Media> = toList(value)
}