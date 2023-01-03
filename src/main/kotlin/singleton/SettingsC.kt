package singleton

class SettingsC private constructor() {


    companion object {
        private class SettingsHolder {
            companion object {
                val INSTANCE: SettingsC = SettingsC()
            }
        }

        fun getInstance(): SettingsC {
            return SettingsHolder.INSTANCE
        }
    }
}
