import Foundation

@objc public class MiPrimer: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
