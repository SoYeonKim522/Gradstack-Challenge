package ai.gradstack.challenge.ui.screens

import ai.gradstack.challenge.ui.theme.SlateBg
import ai.gradstack.challenge.ui.theme.SlateBorder
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SkillChipRow(skills: List<String>) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        skills.forEach { tag ->
            val trimmed = tag.trim()
            if (trimmed.isNotBlank()) {
                Surface(
                    color = SlateBorder,
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        text = trimmed,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        color = SlateBg,
                        modifier = Modifier.padding(
                            horizontal = 6.dp,
                            vertical = 3.dp
                        )
                    )
                }
            }
        }
    }
}