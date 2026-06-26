package ai.gradstack.challenge.mock

import ai.gradstack.challenge.model.*
import java.time.LocalDate
import java.time.LocalDateTime

object ProfileMockData {

    private val dhp = DigitalHumanProfile(
        userId = "user-jordan-001",
        createdAt = LocalDateTime.of(2024, 6, 1, 9, 0),
        lastUpdatedAt = LocalDateTime.of(2025, 1, 15, 14, 30),

        myJourney = PersonalStory(
            headline = "Communications graduate turning digital content into genuine human connection.",
            narrative = "I graduated from UTS 18 months ago with a Bachelor of Communications, " +
                    "majoring in Digital and Social Media. Since then I've been working casual " +
                    "hospitality shifts while applying relentlessly for marketing and content roles. " +
                    "I've sent over 40 applications and heard back from 3 — all rejections. " +
                    "I know I have the skills. I just haven't found the right way to show them yet.",
            values = listOf("Inclusion", "Creativity", "Honesty"),
            strengths = listOf("Storytelling", "Content Strategy", "Audience Research")
        ),

        whyIDoWhatIDo = PersonalStory(
            headline = "I don't just write — I research, structure, and craft messages that move people toward action.",
            narrative = "Good communication makes complex ideas accessible to everyone. " +
                    "I approach every brief as a chance to do something that hasn't been done before, " +
                    "and I'd rather say something true and uncomfortable than something polished and empty.",
            values = listOf("Inclusion", "Creativity", "Honesty"),
            strengths = listOf("Copywriting", "Strategic Framing", "Editorial Integrity")
        ),

        experience = listOf(
            ExperienceEntry(
                id = "exp-001",
                title = "Staff Writer & Digital Editor",
                organisation = "UTS Student Media — The Comma",
                employmentType = EmploymentType.CASUAL,
                startDate = LocalDate.of(2022, 3, 1),
                endDate = LocalDate.of(2024, 11, 30),
                description = "Grew Instagram following from 400 to 2,100 over 18 months. " +
                        "Published 30+ articles across lifestyle, culture, and campus news verticals.",
                skillsDemonstrated = listOf("Content Writing", "Social Media", "Editorial Strategy")
            ),
            ExperienceEntry(
                id = "exp-002",
                title = "Social Media Manager",
                organisation = "Local Café (Freelance)",
                employmentType = EmploymentType.FREELANCE,
                startDate = LocalDate.of(2024, 1, 1),
                endDate = null,
                description = "Managing Instagram and TikTok. Increased average post reach by 3x " +
                        "in 3 months through consistent scheduling and Reels-first strategy.",
                skillsDemonstrated = listOf("Social Media", "Content Creation", "Analytics")
            )
        ),

        projects = listOf(
            ProjectEntry(
                id = "proj-001",
                title = "Capstone Campaign — Canteen Australia",
                description = "Full integrated marketing campaign developed for a real client brief.",
                role = "Lead Strategist & Copywriter",
                problem = "Canteen Australia needed a campaign to increase awareness among 18–25 year olds.",
                challenges = "Balancing emotional sensitivity with an actionable call to action.",
                outcomes = "Awarded Best in Cohort by industry panel judges.",
                skillsDemonstrated = listOf("Campaign Strategy", "Copywriting", "Audience Research"),
                startDate = LocalDate.of(2023, 7, 1),
                completedAt = LocalDate.of(2023, 11, 30),
                linkedPlatformId = null
            )
        ),

        education = listOf(
            EducationEntry(
                id = "edu-001",
                institution = "University of Technology Sydney (UTS)",
                qualification = "Bachelor of Communications",
                fieldOfStudy = "Digital and Social Media",
                pathwayType = PathwayType.UNIVERSITY,
                startDate = LocalDate.of(2021, 3, 1),
                completedAt = LocalDate.of(2023, 11, 30),
                graduationDate = LocalDate.of(2024, 5, 1)
            )
        ),

        vciScore = VciScore(
            overallScore = 68.0f,
            assessedAt = LocalDateTime.of(2024, 11, 1, 10, 0),
            expiresAt = LocalDate.of(2025, 11, 1),
            layers = VciLayers(
                aiFluency = GafiLayer(
                    level = GafiLevel.L2,
                    overallScore = 52.0f,
                    assessedAt = LocalDateTime.of(2024, 11, 1, 10, 0),
                    expiresAt = LocalDate.of(2025, 11, 1),
                    dimensionScores = mapOf(
                        GafiDimension.DELEGATION to 55.0f,
                        GafiDimension.DESCRIPTION to 60.0f,
                        GafiDimension.DISCERNMENT to 48.0f,
                        GafiDimension.DILIGENCE to 45.0f
                    ),
                    recommendedUpskillingPath = "Practice prompt engineering with real content briefs.",
                    benchmarkSector = "Marketing & Communications"
                ),
                layer2 = CapabilityLayer(
                    layerName = "Core Skills",
                    score = 78.0f,
                    assessedAt = LocalDateTime.of(2024, 11, 1, 10, 0),
                    expiresAt = LocalDate.of(2025, 11, 1),
                    skills = listOf(
                        VerifiedSkill(
                            skillName = "Content Writing & Copywriting",
                            proficiencyLevel = ProficiencyLevel.INTERMEDIATE,
                            verifiedAt = LocalDateTime.of(2024, 11, 1, 10, 0),
                            evidenceSource = "VCI Assessment"
                        ),
                        VerifiedSkill(
                            skillName = "Social Media Strategy",
                            proficiencyLevel = ProficiencyLevel.INTERMEDIATE,
                            verifiedAt = LocalDateTime.of(2024, 11, 1, 10, 0),
                            evidenceSource = "VCI Assessment"
                        ),
                        VerifiedSkill(
                            skillName = "Community Management",
                            proficiencyLevel = ProficiencyLevel.BEGINNER,
                            verifiedAt = null,
                            evidenceSource = null
                        )
                    ),
                    benchmarkSector = "Marketing & Communications"
                ),
                layer3 = CapabilityLayer(
                    layerName = "Applied Experience",
                    score = 65.0f,
                    assessedAt = null,
                    expiresAt = LocalDate.of(2025, 11, 1),
                    skills = emptyList(),
                    benchmarkSector = null
                ),
                layer4 = CapabilityLayer(
                    layerName = "Collaboration & Teamwork",
                    score = 60.0f,
                    assessedAt = null,
                    expiresAt = LocalDate.of(2025, 11, 1),
                    skills = emptyList(),
                    benchmarkSector = null
                ),
                layer5 = CapabilityLayer(
                    layerName = "Professional Readiness",
                    score = 55.0f,
                    assessedAt = null,
                    expiresAt = LocalDate.of(2025, 11, 1),
                    skills = emptyList(),
                    benchmarkSector = null
                )
            )
        ),

        veiScore = VeiScore(
            overallScore = 74.0f,
            calculatedAt = LocalDateTime.of(2025, 1, 10, 9, 0),
            expiresAt = LocalDate.of(2026, 1, 10),
            dimensions = VeiDimensions(
                employerReadiness = 70.0f,
                industryAlignment = 78.0f,
                collaboration = 76.0f,
                executionConsistency = 72.0f,
                professionalMaturity = 74.0f
            )
        ),

        roleMatches = listOf(
            RoleMatch(
                roleId = "role-content-strategist",
                roleName = "Content Strategist",
                matchScore = 81.0f,
                matchedCapabilities = listOf("Content Writing", "Social Media Strategy", "Audience Research")
            ),
            RoleMatch(
                roleId = "role-social-media-manager",
                roleName = "Social Media Manager",
                matchScore = 76.0f,
                matchedCapabilities = listOf("Social Media Strategy", "Community Management", "Analytics")
            )
        ),

        linkedPlatforms = listOf(
            LinkedPlatform(
                id = "plat-001",
                platform = ExternalPlatform.WEBPAGE,
                url = "https://thecomma.uts.edu.au",
                displayLabel = "The Comma — UTS Student Media",
                embedDisplayMode = EmbedDisplayMode.LINK_ONLY,
                addedAt = LocalDateTime.of(2024, 6, 5, 10, 0),
                lastVerifiedAt = LocalDateTime.of(2025, 1, 10, 9, 0)
            ),
            LinkedPlatform(
                id = "plat-002",
                platform = ExternalPlatform.WEBPAGE,
                url = "https://instagram.com/example_cafe",
                displayLabel = "Freelance Work — Local Café Instagram",
                embedDisplayMode = EmbedDisplayMode.LINK_ONLY,
                addedAt = LocalDateTime.of(2024, 6, 5, 10, 0),
                lastVerifiedAt = null
            )
        ),

        scoreHistory = listOf(
            ScoreSnapshot(
                snapshotId = "snap-001",
                takenAt = LocalDateTime.of(2024, 11, 1, 10, 0),
                vciOverall = 68.0f,
                veiOverall = null,
                gafiLevel = GafiLevel.L2,
                triggerReason = "Initial Assessment"
            ),
            ScoreSnapshot(
                snapshotId = "snap-002",
                takenAt = LocalDateTime.of(2025, 1, 10, 9, 0),
                vciOverall = 68.0f,
                veiOverall = 74.0f,
                gafiLevel = GafiLevel.L2,
                triggerReason = "VEI Assessment Completed"
            )
        )
    )

    val userProfile = UserProfile(
        id = "user-jordan-001",
        createdAt = LocalDateTime.of(2024, 6, 1, 9, 0),
        lastUpdatedAt = LocalDateTime.of(2025, 1, 15, 14, 30),

        firstName = "Jordan",
        lastName = "Lee",
        preferredName = null,
        image = "https://example.com/avatars/jordan.jpg",
        email = "jordan.lee@email.com",
        location = "Sydney, NSW",

        linkedInUrl = "https://linkedin.com/in/jordanlee",
        personalWebsite = "",
        pathwayType = PathwayType.UNIVERSITY,
        workRight = WorkRightType.AUSTRALIAN_CITIZEN,

        careerGoals = CareerGoals(
            targetRoles = listOf("Content Strategist", "Social Media Manager", "Marketing Coordinator"),
            targetIndustries = listOf("Media & Communications", "Non-Profit", "Tech"),
            preferredEmploymentType = listOf(EmploymentType.FULL_TIME, EmploymentType.CONTRACT),
            openToRelocation = false,
            availableFrom = LocalDate.of(2026, 2, 1),
            lastUpdatedAt = LocalDateTime.of(2026, 1, 15, 14, 30)
        ),

        dhp = dhp
    )
}