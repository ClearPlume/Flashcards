package top.fallenangel.flashcards.ui.theme.home

import androidx.lifecycle.ViewModel
import kotlin.system.exitProcess

class HomeViewModel : ViewModel() {
    fun onAdd(): () -> Unit {
        return {
            println("添加新卡片")
        }
    }

    fun onDelete(): () -> Unit {
        return {
            println("删除已有卡片")
        }
    }

    fun onImport(): () -> Unit {
        return {
            println("从文件导入新卡片")
        }
    }

    fun onExport(): () -> Unit {
        return {
            println("将卡片导出到文件")
        }
    }

    fun onPractice(): () -> Unit {
        return {
            println("开始练习")
        }
    }

    fun onExit(): () -> Unit {
        return {
            exitProcess(0)
        }
    }
}