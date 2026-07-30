package com.blueray.rowsandcolumns.basic_layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fullscreen
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices.NEXUS_10
import androidx.compose.ui.tooling.preview.Devices.NEXUS_7
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/*
 * Data class representing one project card.
 */
data class Project(
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
    val isCompleted: Boolean = true
)

/*
 * Sample project data.
 */
private val sampleProjects = listOf(
    Project(
        id = 1,
        title = "Project X",
        description = "This is a short description.",
        date = "Mar 5, 10:00"
    ),
    Project(
        id = 2,
        title = "Project X",
        description = """
            Bacon ipsum dolor amet pork chop flank landjaeger cupim chicken ham, 
            tail kielbasa swine burgdoggen spare ribs meatball. Tongue burgdoggen 
            shank meatloaf ham hock tenderloin turkey, buffalo spare ribs. 
            Capicola tri-tip spare ribs, drumstick landjaeger meatloaf chicken 
            pork chop ground round turducken beef ribs shankle ribeye. Hamburger 
            burgdoggen shank, tri-tip jerky prosciutto rump brisket meatloaf 
            buffalo beef ribs short ribs t-bone sausage.
        """.trimIndent(),
        date = "Mar 5, 10:00"
    ),
    Project(
        id = 3,
        title = "Compose Project",
        description = "Learning Rows, Columns, Box, Cards and LazyColumn.",
        date = "Mar 8, 2:30"
    )
)

@Composable
fun ProjectCardsTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            background = Color(0xFFF6F6F8),
            surface = Color.White
        ),
        content = content
    )
}

@Composable
fun ProjectScreen() {
    Scaffold(
        containerColor = Color(0xFFF6F6F8)
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 20.dp
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = sampleProjects,
                key = { project -> project.id }
            ) { project ->

                ProjectCard(
                    project = project,
                    onMenuClick = {
                        // Handle the three-dot menu click.
                    },
                    onFullscreenClick = {
                        // Handle the fullscreen button click.
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectCard(
    project: Project,
    onMenuClick: () -> Unit,
    onFullscreenClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val cardColor = Color(0xFFED7457)

    Card(
        onClick = {
            // Handle clicking the entire card.
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 170.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 20.dp,
                    top = 18.dp,
                    end = 10.dp,
                    bottom = 10.dp
                )
        ) {

            ProjectCardContent(
                project = project,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 50.dp,
                        end = 40.dp,
                        bottom = 48.dp
                    )
            )

            CompletionIcon(
                completed = project.isCompleted,
                modifier = Modifier.align(Alignment.TopStart)
            )

            IconButton(
                onClick = onMenuClick,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(44.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.MoreHoriz,
                    contentDescription = "Project options",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }

            Row(
                modifier = Modifier.align(Alignment.BottomEnd),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = project.date,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )

                IconButton(
                    onClick = onFullscreenClick,
                    modifier = Modifier.size(42.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Fullscreen,
                        contentDescription = "Open project",
                        tint = Color.White,
                        modifier = Modifier.size(27.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun ProjectCardContent(
    project: Project,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = project.title,
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = project.description,
            color = Color.White.copy(alpha = 0.92f),
            fontSize = 19.sp,
            lineHeight = 25.sp
        )
    }
}

@Composable
private fun CompletionIcon(
    completed: Boolean,
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = Icons.Outlined.CheckCircle,
        contentDescription = if (completed) {
            "Project completed"
        } else {
            "Project not completed"
        },
        modifier = modifier.size(32.dp),
        tint = if (completed) {
            Color.White
        } else {
            Color.White.copy(alpha = 0.45f)
        }
    )
}

@Preview(
    showBackground = true,
    device = NEXUS_7
)
@Composable
private fun ProjectScreenPreviewMobile() {
    ProjectCardsTheme {
        ProjectScreen()
    }
}

@Preview(
    showBackground = true,
    device = NEXUS_10,

)
@Composable
private fun ProjectScreenPreview() {
    ProjectCardsTheme {
        ProjectScreen()
    }
}