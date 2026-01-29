package com.example.deeplinkingkmp.navigation

//Helper of Swift side onOpenURL lambda to call -> KMP side
object ExternalUriHandler {

    private var cached: String? = null

    //4. listener will be register from compose side, which may take some time
    // (not yet fully composed), after uri from ios side is delivered
    var listener: ((uri: String) -> Unit)? = null
        //5. from compose ui, now the listener is initialized
        set(value) {
            field = value
            //6. when it has been initialized
            if (value != null) {
                //7. check is there a cached deep link url from ios
                cached?.let { cachedUrl ->
                    //8. if there is immediately call this listener
                    value.invoke(cachedUrl)
                }
                //9. reset cached value to default -> null
                cached = null
            }
        }

    //1. Call onNewUri
    fun onNewUri(uri: String) {
        //2. cached ios uri
        cached = uri
        //3. main issue is that ios app may be closed, and uri might be delivered
        // before listener is fully registered
        listener?.let {
            it.invoke(uri)
            cached = null
        }
    }
}