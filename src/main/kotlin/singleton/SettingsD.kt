package singleton

import java.io.Serializable

class SettingsD private constructor() : Serializable {


    companion object {
        private class SettingsHolder {
            companion object {
                val INSTANCE: SettingsD = SettingsD()
            }
        }

        fun getInstance(): SettingsD {
            return SettingsHolder.INSTANCE
        }
    }

    //역직렬화 대응 방안
    protected fun readResolve(): Any {
        return getInstance()
    }
}
