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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import top.fallenangel.flashcards.ui.theme.FlashcardsTheme

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
        ConstraintLayout(modifier = Modifier.fillMaxSize(1f)) {
            val context = LocalContext.current
            val (title, add, delete, import, export, practice, exit) = createRefs()
            val title2Top = 110.dp
            val btn2Title = 60.dp
            val btnSpace = 30.dp

            Text(
                modifier = Modifier
                    .constrainAs(title) {
                        top.linkTo(parent.top, margin = title2Top)
                        centerHorizontallyTo(parent)
                    },
                text = "抽 认 卡",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )

            Button(onClick = { toast("添加新卡片", context) },
                modifier = Modifier.constrainAs(add) {
                    top.linkTo(title.bottom, margin = btn2Title)
                    centerHorizontallyTo(parent)
                }) {
                Text(text = "添加新卡片")
            }

            Button(onClick = { toast("删除已有卡片", context) },
                modifier = Modifier.constrainAs(delete) {
                    top.linkTo(add.bottom, margin = btnSpace)
                    centerHorizontallyTo(parent)
                }) {
                Text(text = "删除已有卡片")
            }

            Button(onClick = { toast("从文件导入新卡片", context) },
                modifier = Modifier.constrainAs(import) {
                    top.linkTo(delete.bottom, margin = btnSpace)
                    centerHorizontallyTo(parent)
                }) {
                Text(text = "从文件导入新卡片")
            }

            Button(onClick = { toast("将卡片导出到文件", context) },
                modifier = Modifier.constrainAs(export) {
                    top.linkTo(import.bottom, margin = btnSpace)
                    centerHorizontallyTo(parent)
                }) {
                Text(text = "将卡片导出到文件")
            }

            Button(onClick = { toast("开始练习", context) },
                modifier = Modifier.constrainAs(practice) {
                    top.linkTo(export.bottom, margin = btnSpace)
                    centerHorizontallyTo(parent)
                }) {
                Text(text = "开始练习")
            }

            Button(onClick = { toast("退出", context) },
                modifier = Modifier.constrainAs(exit) {
                    top.linkTo(practice.bottom, margin = btnSpace)
                    centerHorizontallyTo(parent)
                }) {
                Text(text = "退出")
            }
        }
    }
}
