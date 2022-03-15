package com.example.fishwatch.data.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FishResponse(
    @SerializedName("Animal Health")
    val animal_Health: String,
    @SerializedName("Availability")
    val availability: String,
    @SerializedName("Biology")
    val biology: String,
    @SerializedName("Bycatch")
    val bycatch: String,
    @SerializedName("Calories")
    val calories: String,
    @SerializedName("Carbohydrate")
    val carbohydrate: String,
    @SerializedName("Cholesterol")
    val cholesterol: String,
    @SerializedName("Color")
    val color: String,
    @SerializedName("Disease Treatment and Prevention")
    val diseaseTreatmentPrevention: String?,
    @SerializedName("Diseases in Salmon")
    val diseases_in_Salmon: String,
    @SerializedName("Displayed Seafood Profile Illustration")
    val displayed_Seafood_Profile_Illustration: String,
    @SerializedName("Ecosystem Services")
    val ecosystemServices: String,
    @SerializedName("Environmental Considerations")
    val environmentalConsiderations: String,
    @SerializedName("Environmental Effects")
    val environmentalEffects: String,
    @SerializedName("Farming Methods")
    val farmingMethods: String,
    @SerializedName("Fat, Total")
    val fatTotal: String,
    @SerializedName("Feeds")
    val feeds: String,
    @SerializedName("Fiber, Total Dietary")
    val fiberTotalDietary: String,
    @SerializedName("Fishery Management")
    val fisheryManagement: String,
    @SerializedName("Fishing Rate")
    val fishingRate: String,

    @SerializedName("Habitat")
    val habitat: String,
    @SerializedName("Habitat Impacts")
    val habitatImpacts: String,
    @SerializedName("Harvest")
    val harvest: String,
    @SerializedName("Harvest Type")
    val harvestType: String,
    @SerializedName("Health Benefits")
    val healthBenefits: String,
    @SerializedName("Human Health")
    val humanHealth: String,

    //@SerializedName("Image Gallery")
    //  val imageGallery: List<SpeciesIllustrationPhoto>?,

    @SerializedName("Location")
    val location: String,

    @SerializedName("Management")
    val management: String,
    @SerializedName("NOAA Fisheries Region")
    val nOAA_FisheriesRegion: String,

    @SerializedName("Path")
    val path: String,
    @SerializedName("Physical Description")
    val physicalDescription: String,

    @SerializedName("Population")
    val Population: String,
    @SerializedName("Population Status")
    val populationStatus: String,

    @SerializedName("Production")
    val production: String,
    @SerializedName("Protein")
    val protein: String,
    @SerializedName("Quote")
    val quote: String,
    @SerializedName("Quote Background Color")
    val quoteBackgroundColor: String,

    @SerializedName("Research")
    val research: String,
    @SerializedName("Saturated Fatty Acids, Total")
    val saturatedFattyAcidsTotal: String,

    @SerializedName("Scientific Name")
    val scientificName: String,

    @SerializedName("Selenium")
    val selenium: String,
    @SerializedName("Serving Weight")
    val servingWeight: String,
    @SerializedName("Servings")
    val servings: String,


    @SerializedName("Sodium")
    val sodium: String,
    @SerializedName("Source")
    val source: String,
    @SerializedName("Species Aliases")
    val speciesAliases: String,
    @SerializedName("Species Illustration Photo")
    val speciesIllustrationPhoto: SpeciesIllustrationPhoto,

    @SerializedName("Species Name")
    val species_Name: String,

    @SerializedName("Taste")
    val taste: String,

    @SerializedName("Texture")
    val texture: String


) : Serializable
