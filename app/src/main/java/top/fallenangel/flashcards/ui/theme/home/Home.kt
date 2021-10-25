package top.fallenangel.flashcards.ui.theme.home

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import top.fallenangel.flashcards.Color
import top.fallenangel.flashcards.R

@Composable
@OptIn(ExperimentalPagerApi::class)
fun Home(model: HomeViewModel = viewModel()) {
    Scaffold(backgroundColor = Color(value = "F1F1F1")) {
        val constraintSet = decoupledConstraint(
            title2Top = 110.dp,
            btn2Title = 60.dp,
            btnSpace = 30.dp
        )
        val items = listOf(1, 2, 3, 4, 5)

        ConstraintLayout(
            modifier = Modifier.fillMaxSize(1f),
            constraintSet = constraintSet
        ) {
            Text(
                modifier = Modifier.layoutId("title"),
                text = stringResource(id = R.string.home_title),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )

            Button(
                onClick = model::onPractice,
                modifier = Modifier.layoutId("practice")
            ) {
                Text(text = stringResource(id = R.string.home_practice_btn))
            }

            Button(
                onClick = model::onAdd,
                modifier = Modifier.layoutId("add")
            ) {
                Text(text = stringResource(id = R.string.home_add_btn))
            }

            Button(
                onClick = model::onDelete,
                modifier = Modifier.layoutId("delete")
            ) {
                Text(text = stringResource(id = R.string.home_delete_btn))
            }

            Button(
                onClick = model::onImport,
                modifier = Modifier.layoutId("import")
            ) {
                Text(text = stringResource(id = R.string.home_import_btn))
            }

            Button(
                onClick = model::onExport,
                modifier = Modifier.layoutId("export")
            ) {
                Text(text = stringResource(id = R.string.home_export_btn))
            }

            Button(
                onClick = model::onExit,
                modifier = Modifier.layoutId("exit")
            ) {
                Text(text = stringResource(id = R.string.home_exit_btn))
            }

            HorizontalPager(
                count = 5,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .layoutId("pager")
            ) {
                val item = items[it]
                var selected by remember { mutableStateOf(false) }
                val bgColor by animateColorAsState(
                    targetValue = if (selected) {
                        Color(value = "FF00FF77")
                    } else {
                        Color(value = "F1F1F1")
                    }
                )

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .background(
                            color = bgColor,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .size(100.dp)
                        .clickable { selected = !selected }
                ) {
                    Text(
                        text = item.toString(),
                        fontSize = 20.sp
                    )
                }
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
        val pager = createRefFor("pager")

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

        constrain(pager) {
            top.linkTo(exit.bottom, margin = btnSpace)
            centerHorizontallyTo(parent)
        }
    }
}
