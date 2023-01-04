package singleton

import java.io.Serializable

class SettingsC private constructor() : Serializable {


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
