package com.example.ussd.models

class Internet {
    var name:String? = null
    var narxi:String? = null
    var muddati:String? = null
    var kodi:String? = null

    constructor(name: String?, narxi: String?, muddati: String?) {
        this.name = name
        this.narxi = narxi
        this.muddati = muddati
    }

    constructor(name: String?, narxi: String?, muddati: String?, kodi: String?) {
        this.name = name
        this.narxi = narxi
        this.muddati = muddati
        this.kodi = kodi
    }


}