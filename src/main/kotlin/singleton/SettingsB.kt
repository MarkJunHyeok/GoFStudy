package singleton

class SettingsB private constructor() {

    companion object {
        private val INSTANCE: SettingsB = SettingsB()

        fun getInstance(): SettingsB {
            return INSTANCE
        }
    }
}
