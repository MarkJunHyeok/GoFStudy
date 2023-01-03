package singleton

class SettingsA private constructor() {

    companion object {
        private var instance: SettingsA? = null

        fun getInstance(): SettingsA {
            if (instance == null) {
                instance = SettingsA()
            }

            return instance!!
        }
    }
}
