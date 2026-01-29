import SwiftUI

@main
struct iOSApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView()
                .onOpenURL(perform: {url in
                    //callback lambda that ios will call when open with specific url
                })
        }
    }
}