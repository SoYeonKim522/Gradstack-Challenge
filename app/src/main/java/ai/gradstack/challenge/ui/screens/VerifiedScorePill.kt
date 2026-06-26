package ai.gradstack.challenge.ui.screens

import ai.gradstack.challenge.ui.theme.GradstackGreen
import ai.gradstack.challenge.ui.theme.GradstackGreenLight
import ai.gradstack.challenge.ui.theme.NeutralBackground
import ai.gradstack.challenge.ui.theme.NeutralBorder
import ai.gradstack.challenge.ui.theme.NeutralTextTertiary
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VerifiedScorePill(
    label: String,
    value: String,
    subtitle: String,
    isVerified: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(if (isVerified) GradstackGreenLight else NeutralBackground)
            .border(
                width = 1.dp,
                color = if (isVerified) GradstackGreen.copy(alpha = 0.2f) else NeutralBorder,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 10.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (isVerified) GradstackGreen else NeutralTextTertiary,
            letterSpacing = 0.5.sp
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = value,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = if (isVerified) GradstackGreen else NeutralTextTertiary
        )
        Spacer(modifier = Modifier.height(1.dp))
        Text(
            text = subtitle,
            fontSize = 9.sp,
            color = if (isVerified) GradstackGreen.copy(alpha = 0.7f) else NeutralTextTertiary
        )
    }
}