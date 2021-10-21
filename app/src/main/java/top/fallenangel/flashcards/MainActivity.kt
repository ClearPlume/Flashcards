package top.fallenangel.flashcards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import top.fallenangel.flashcards.ui.theme.FlashcardsTheme
import kotlin.system.exitProcess

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlashcardsTheme {
                MainPage()
            }
        }
    }
}

@Preview
@Composable
fun MainPage() {
    Scaffold(backgroundColor = Color(value = "F1F1F1")) {
        val constraintSet = decoupledConstraint(
            title2Top = 110.dp,
            btn2Title = 60.dp,
            btnSpace = 30.dp
        )

        ConstraintLayout(
            modifier = Modifier.fillMaxSize(1f),
            constraintSet = constraintSet
        ) {
            Text(
                modifier = Modifier.layoutId("title"),
                text = "抽 认 卡",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )

            Button(
                onClick = onPractice(),
                modifier = Modifier.layoutId("practice")
            ) {
                Text(text = "开始练习")
            }

            Button(
                onClick = onAdd(),
                modifier = Modifier.layoutId("add")
            ) {
                Text(text = "添加新卡片")
            }

            Button(
                onClick = onDelete(),
                modifier = Modifier.layoutId("delete")
            ) {
                Text(text = "删除已有卡片")
            }

            Button(
                onClick = onImport(),
                modifier = Modifier.layoutId("import")
            ) {
                Text(text = "从文件导入新卡片")
            }

            Button(
                onClick = onExport(),
                modifier = Modifier.layoutId("export")
            ) {
                Text(text = "将卡片导出到文件")
            }

            Button(
                onClick = onExit(),
                modifier = Modifier.layoutId("exit")
            ) {
                Text(text = "退出")
            }
        }
    }
}

private fun decoupledConstraint(title2Top: Dp, btn2Title: Dp, btnSpace: Dp): ConstraintSet {
    return ConstraintSet {
        val title = createRefFor("title")
        val practice = createRefFor("practice")
        val add = createRefFor("add")
        val delete = createRefFor("delete")
        val import = createRefFor("import")
        val export = createRefFor("export")
        val exit = createRefFor("exit")

        constrain(title) {
            top.linkTo(parent.top, margin = title2Top)
            centerHorizontallyTo(parent)
        }

        constrain(practice) {
            top.linkTo(title.bottom, margin = btn2Title)
            centerHorizontallyTo(parent)
        }

        constrain(add) {
            top.linkTo(practice.bottom, margin = btnSpace)
            centerHorizontallyTo(parent)
        }

        constrain(delete) {
            top.linkTo(add.bottom, margin = btnSpace)
            centerHorizontallyTo(parent)
        }

        constrain(import) {
            top.linkTo(delete.bottom, margin = btnSpace)
            centerHorizontallyTo(parent)
        }

        constrain(export) {
            top.linkTo(import.bottom, margin = btnSpace)
            centerHorizontallyTo(parent)
        }

        constrain(exit) {
            top.linkTo(export.bottom, margin = btnSpace)
            centerHorizontallyTo(parent)
        }
    }
}

private fun onAdd(): () -> Unit {
    return {
        println("添加新卡片")
    }
}

private fun onDelete(): () -> Unit {
    return {
        println("删除已有卡片")
    }
}

private fun onImport(): () -> Unit {
    return {
        println("从文件导入新卡片")
    }
}

private fun onExport(): () -> Unit {
    return {
        println("将卡片导出到文件")
    }
}

private fun onPractice(): () -> Unit {
    return {
        println("开始练习")
    }
}

private fun onExit(): () -> Unit {
    return {
        exitProcess(0)
    }
}
