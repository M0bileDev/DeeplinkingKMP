import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView()
                .onOpenURL(perform: {url in
                    //open ios devtools and type -> xcrun simctl openurl booted "myapp://deep-link.com/item/15"
                    //callback lambda that ios will call when open with specific url
                    ExternalUriHandler.shared.onNewUri(uri: url.absoluteString)
                })
        }
    }
}