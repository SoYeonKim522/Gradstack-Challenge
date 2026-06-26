package ai.gradstack.challenge.ui

import ai.gradstack.challenge.mock.ProfileMockData
import ai.gradstack.challenge.ui.screens.GafiPill
import ai.gradstack.challenge.ui.screens.SkillCard
import ai.gradstack.challenge.ui.screens.SkillChipRow
import ai.gradstack.challenge.ui.screens.VerifiedScorePill
import ai.gradstack.challenge.ui.theme.GradstackGreen
import ai.gradstack.challenge.ui.theme.EmeraldGreen
import ai.gradstack.challenge.ui.theme.SlateBg
import ai.gradstack.challenge.ui.theme.SlateBorder
import ai.gradstack.challenge.ui.theme.SlateCard
import ai.gradstack.challenge.ui.theme.TextMuted
import ai.gradstack.challenge.ui.theme.TextPrimary
import ai.gradstack.challenge.ui.theme.TextSecondary
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.DateTimeFormatter


// ProfileScreen
// Mock data is injected directly

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {

    // State from mock data
    var profile by remember { mutableStateOf(ProfileMockData.userProfile) }
    var dhp by remember { mutableStateOf(ProfileMockData.userProfile.dhp) }
    val projectItems = remember { ProfileMockData.userProfile.dhp.projects.toMutableStateList() }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = SlateBg,
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(GradstackGreen, RoundedCornerShape(4.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "G",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Black
                            )
                        }
                        Text(
                            "DHP",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 2.sp,
                                color = TextPrimary,
                                fontFamily = FontFamily.Monospace
                            )
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = SlateBg,
                    titleContentColor = TextPrimary
                )
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                // HEADER
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                ) {
                    // Avatar
                    Box(
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .align(Alignment.BottomStart)
                            .size(100.dp)
                            .border(
                                width = 3.dp,
                                brush = Brush.linearGradient(listOf(GradstackGreen, EmeraldGreen)),
                                shape = CircleShape
                            )
                            .padding(3.dp)
                            .clip(CircleShape)
                            .background(
                                Brush.linearGradient(
                                    listOf(Color(0xFF0A3D2E), Color(0xFF0D2137))
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = profile.firstName
                                .split(" ")
                                .take(2)
                                .joinToString("") { it.first().uppercase() },
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = GradstackGreen
                        )
                    }
                }

                // IDENTITY
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 12.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = profile.firstName,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier.padding(top = 4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Location",
                            tint = GradstackGreen,
                            modifier = Modifier.size(14.dp)
                        )
                        Text(text = profile.location, fontSize = 13.sp, color = TextSecondary)
                        Text(text = "•", color = TextMuted, modifier = Modifier.padding(horizontal = 4.dp))
                        Surface(color = SlateCard, shape = RoundedCornerShape(4.dp)) {
                            Text(
                                text = "UTS Alumni",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = GradstackGreen,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                                fontFamily = FontFamily.Monospace
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = profile.careerGoals.targetIndustries.joinToString(", "),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = TextPrimary,
                        lineHeight = 22.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.dp, SlateBorder, RoundedCornerShape(8.dp))
                            .background(SlateCard.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
                            .padding(12.dp)
                    )
                }

                HorizontalDivider(
                    color = SlateBorder,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp)
                )

                // CAPABILITY SNAPSHOT
                Text(
                    text = "VERIFIED CAPABILITY SNAPSHOT",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = GradstackGreen,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 6.dp),
                    fontFamily = FontFamily.Monospace,
                    letterSpacing = 1.5.sp
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        VerifiedScorePill(
                            label = "VEI",
                            value = dhp.veiScore?.overallScore.let { "%.0f".format(it) } ?: "—",
                            subtitle = "Employability",
                            isVerified = dhp.veiScore != null,
                            modifier = Modifier.weight(1f)
                        )
                        VerifiedScorePill(
                            label = "VCI",
                            value = dhp.vciScore?.overallScore.let { "%.0f".format(it) } ?: "—",
                            subtitle = "Capability",
                            isVerified = dhp.vciScore != null,
                            modifier = Modifier.weight(1f)
                        )
                        GafiPill(
                            level = null,
                            levelShort = dhp.vciScore?.layers?.aiFluency?.level.toString(),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                // SKILL
                SkillCard(
                    skills = dhp.vciScore?.layers?.layer2?.skills ?: emptyList()
                )

                // MY JOURNEY & VALUES
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 6.dp),
                    colors = CardDefaults.cardColors(containerColor = SlateCard),
                    border = BorderStroke(1.dp, SlateBorder)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp)
                    ) {
                        Text(
                            text = "MY JOURNEY",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = GradstackGreen,
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = 1.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = dhp.myJourney.headline,
                            fontSize = 13.sp,
                            color = TextPrimary,
                            lineHeight = 19.sp
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "VALUES",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = GradstackGreen,
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = 1.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = dhp.whyIDoWhatIDo.headline,
                            fontSize = 13.sp,
                            color = TextPrimary,
                            lineHeight = 19.sp
                        )
                    }
                }

                // Project
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "PROJECT",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = GradstackGreen,
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = 1.5.sp
                        )

                        IconButton(
                            onClick = { },
                            modifier = Modifier
                                .background(GradstackGreen.copy(alpha = 0.1f), CircleShape)
                                .size(28.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add Evidence",
                                tint = GradstackGreen,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    if (projectItems.isEmpty()) {
                        Text(
                            "No evidence items yet",
                            fontSize = 13.sp,
                            color = TextSecondary,
                            modifier = Modifier.padding(vertical = 12.dp)
                        )
                    } else {
                        projectItems.forEachIndexed { index, item ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 12.dp),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                // Evidence card
                                Card(
                                    modifier = Modifier.weight(1f),
                                    colors = CardDefaults.cardColors(containerColor = SlateCard),
                                    border = BorderStroke(
                                        width = 1.dp,
                                        color = EmeraldGreen.copy(alpha = 0.35f)
                                    )
                                ) {
                                    Column(modifier = Modifier.padding(12.dp)) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.Top
                                        ) {
                                            Column(modifier = Modifier.weight(1f)) {
                                                Text(
                                                    text = item.title,
                                                    fontSize = 15.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = TextPrimary
                                                )
                                            }
                                        }
                                        Spacer(modifier = Modifier.height(6.dp))
                                        Text(
                                            text = "Role: ${item.role}",
                                            fontSize = 12.sp,
                                            color = TextPrimary,
                                            lineHeight = 17.sp
                                        )
                                        Spacer(modifier = Modifier.height(6.dp))
                                        Text(
                                            text = "Problem: ${item.problem}",
                                            fontSize = 12.sp,
                                            color = TextPrimary,
                                            lineHeight = 17.sp
                                        )
                                        Spacer(modifier = Modifier.height(6.dp))

                                        item.outcomes?.let {
                                            Text(
                                                text = it,
                                                fontSize = 12.sp,
                                                color = TextPrimary,
                                                lineHeight = 17.sp
                                            )
                                        }

                                        Spacer(modifier = Modifier.height(8.dp))

                                        // project-Skill tags
                                        SkillChipRow(item.skillsDemonstrated)

                                        Spacer(modifier = Modifier.height(10.dp))

                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            // Link
                                            dhp.linkedPlatforms.let { url ->
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                                ) {
                                                    Icon(
                                                        imageVector = Icons.Default.Home,
                                                        contentDescription = "Link",
                                                        tint = GradstackGreen,
                                                        modifier = Modifier.size(14.dp)
                                                    )
                                                    Text(
                                                        text = "url",
                                                        fontSize = 11.sp,
                                                        color = GradstackGreen,
                                                        maxLines = 1,
                                                        overflow = TextOverflow.Ellipsis,
                                                        fontWeight = FontWeight.Medium
                                                    )
                                                }
                                            } ?: Spacer(Modifier.weight(1f))

                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // EDUCATION
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 6.dp),
                    colors = CardDefaults.cardColors(containerColor = SlateCard),
                    border = BorderStroke(1.dp, SlateBorder)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .background(SlateBorder, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "Education",
                                tint = GradstackGreen,
                                modifier = Modifier.size(18.dp)
                            )
                        }

                        Column {
                            Text(
                                text = "Bachelor of Communication (Digital & Social Media)",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )
                            Text(
                                text = "University of Technology Sydney (UTS) · Class of 2024",
                                fontSize = 11.sp,
                                color = TextSecondary
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 24.dp)
                        .border(
                            width = 1.dp,
                            brush = Brush.linearGradient(
                                listOf(GradstackGreen.copy(alpha = 0.2f), SlateBorder)
                            ),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .background(SlateCard.copy(alpha = 0.3f), RoundedCornerShape(8.dp))
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    val formatter = DateTimeFormatter.ofPattern("d MMM yyyy")
                    Text(
                        text = "Last Updated: ${profile.careerGoals.lastUpdatedAt.format(formatter)}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = TextSecondary,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

// Preview
@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "ProfileScreen — Jordan (Verified)"
)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}


