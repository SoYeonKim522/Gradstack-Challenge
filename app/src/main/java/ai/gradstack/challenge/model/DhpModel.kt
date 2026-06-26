package ai.gradstack.challenge.model

import java.time.LocalDate
import java.time.LocalDateTime

//put in one file for easy assessment, unlike real environment

data class UserProfile(
    val id: String,
    val createdAt: LocalDateTime,
    val lastUpdatedAt: LocalDateTime,

    // Basic info
    val firstName: String,
    val lastName: String,
    val preferredName: String?,
    val image: String,
    val email: String,
    val location: String,

    val linkedInUrl: String,
    val personalWebsite: String,
    val pathwayType: PathwayType,
    val workRight: WorkRightType,
    val careerGoals: CareerGoals,

    // DHP
    val dhp: DigitalHumanProfile
)

data class CareerGoals(
    val targetRoles: List<String>,
    val targetIndustries: List<String>,
    val preferredEmploymentType: List<EmploymentType>,
    val openToRelocation: Boolean,
    val availableFrom: LocalDate,
    val lastUpdatedAt: LocalDateTime
)

enum class PathwayType {
    UNIVERSITY,
    TAFE,
    BOOTCAMP,
    VOCATIONAL,
    SELF_TAUGHT,
    CAREER_CHANGE,
    RETURN_TO_WORK
}

enum class WorkRightType {
    AUSTRALIAN_CITIZEN,
    PERMANENT_RESIDENT,
    WORKING_HOLIDAY,
    STUDENT_VISA,
    SPONSORED
}

enum class EmploymentType {
    FULL_TIME,
    PART_TIME,
    CASUAL,
    CONTRACT,
    INTERNSHIP,
    FREELANCE
}


// ─────────────────────────────────────────────
// DIGITAL HUMAN PROFILE (DHP)
// ─────────────────────────────────────────────

data class DigitalHumanProfile(
    val userId: String,
    val createdAt: LocalDateTime,
    val lastUpdatedAt: LocalDateTime,

    // Qualitative layers
    val myJourney: PersonalStory,     // who are you as a person, life story, how did you get where you are
    val whyIDoWhatIDo: PersonalStory, //what do you value, why do you want to pursue something

    val experience: List<ExperienceEntry>,
    val projects: List<ProjectEntry>,
    val education: List<EducationEntry>,

    // Quantitative verified layers
    // scores only exist after the relevant assessment is completed
    val vciScore: VciScore?,
    val veiScore: VeiScore?,
    val roleMatches: List<RoleMatch>?, //role match percentage based on VCI & VEI score

    // Embedded portfolio links
    val linkedPlatforms: List<LinkedPlatform>,

    // Score history: visible to the user only, for personal growth tracking
    // Employers see current scores only
    val scoreHistory: List<ScoreSnapshot>
)

// ─────────────────────────────────────────────
// QUALITATIVE LAYERS
// Self-reported, but structured — the human context behind the scores
// ─────────────────────────────────────────────

data class PersonalStory(
    val headline: String,                 // One-line positioning statement
    val narrative: String,                // who they are and where they are going
    val values: List<String>,             // e.g. ["creativity", "inclusion", "impact"]
    val strengths: List<String>,          // e.g. ["storytelling", "stakeholder communication"]
)

data class ExperienceEntry(
    val id: String,
    val title: String,
    val organisation: String,
    val employmentType: EmploymentType,
    val startDate: LocalDate,
    val endDate: LocalDate?,
    val description: String,
    val skillsDemonstrated: List<String>, // Tags that link back to skills in the VCI layer
)

data class ProjectEntry(
    val id: String,
    val title: String,
    val description: String,
    val role: String,                     // contribution
    val problem: String?,
    val challenges: String?,
    val outcomes: String?,       // Tangible result or measurable impact
    val skillsDemonstrated: List<String>,
    val startDate: LocalDate,
    val completedAt: LocalDate?,
    val linkedPlatformId: String?,        // References a LinkedPlatform entry for portfolio embed
)

data class EducationEntry(
    val id: String,
    val institution: String,
    val qualification: String,            // e.g. "Bachelor of Communications"
    val fieldOfStudy: String,
    val pathwayType: PathwayType,         // Captures non-traditional pathways explicitly
    val startDate: LocalDate,
    val completedAt: LocalDate?,
    val graduationDate: LocalDate?,
)

// ─────────────────────────────────────────────
// LINKED PLATFORMS
// Platform-specific embedded portfolio — replaces plain ExternalLink
// DHP shows capability in context, not just a list of URLs
// ─────────────────────────────────────────────

data class LinkedPlatform(
    val id: String,
    val platform: ExternalPlatform,
    val url: String,
    val displayLabel: String,             // e.g. "IELTS Buddy Project"
    val embedDisplayMode: EmbedDisplayMode,
    val addedAt: LocalDateTime,
    val lastVerifiedAt: LocalDateTime?    // System checks periodically that the link still resolves
)

enum class EmbedDisplayMode {
    FULL,           // Full embedded interactive view
    PREVIEW,        // Thumbnail or partial preview visible before the user clicks
    LINK_ONLY       // Fallback if embed is not supported for this platform/content
}


// Platform types for embedded portfolio links
enum class ExternalPlatform {
    GITHUB,
    FIGMA,
    NOTION,
    YOUTUBE,
    WEBPAGE,
    OTHER
}

// ─────────────────────────────────────────────
// VCI — VERIFIED CAPABILITY INDEX
// 5 independently validated layers
// ─────────────────────────────────────────────

data class VciScore(
    val overallScore: Float,
    val assessedAt: LocalDateTime,
    val expiresAt: LocalDate,
    val layers: VciLayers
) {
    val nextRetakableDate: LocalDateTime  //to recommend users to retake
        get() = assessedAt.plusWeeks(8)
}

data class VciLayers(
    val aiFluency: GafiLayer, // = GAFI score
    val layer2: CapabilityLayer,
    val layer3: CapabilityLayer,
    val layer4: CapabilityLayer,
    val layer5: CapabilityLayer
)

data class GafiLayer(
    val level: GafiLevel,  // L1 Aware - L5 Architect
    val overallScore: Float,
    val assessedAt: LocalDateTime,
    val expiresAt: LocalDate,
    val dimensionScores: Map<GafiDimension, Float>, // score per 4D dimension
    val recommendedUpskillingPath: String?,   // Personalised next step generated post-assessment
    val benchmarkSector: String?, //Each layer is benchmarked against sector and role requirements
)

// GAFI: 5 capability levels (L1–L5)
enum class GafiLevel(val label: String, val description: String) {
    L1("Aware", "Understands AI exists and has basic exposure"),
    L2("Assisted", "Uses AI tools with guidance to complete tasks"),
    L3("Applied", "Independently applies AI to real work contexts"),
    L4("Advanced", "Designs AI-assisted workflows; evaluates outputs critically"),
    L5("Architect", "Architects AI systems; shapes how others work with AI")
}

// GAFI 4D (four dimensions of AI fluency)
enum class GafiDimension {
    DELEGATION,     // Knowing what to hand to AI vs handle yourself
    DESCRIPTION,    // Quality of prompts and task framing
    DISCERNMENT,    // Evaluating, correcting, and knowing when to trust AI output
    DILIGENCE       // Consistency, ethics, responsible and accountable use
}


data class CapabilityLayer(
    val layerName: String,
    val score: Float,
    val assessedAt: LocalDateTime?,
    val expiresAt: LocalDate,
    val skills: List<VerifiedSkill>,
    val benchmarkSector: String?, //Each layer is benchmarked against sector and role requirements
)

data class VerifiedSkill(
    val skillName: String,
    val proficiencyLevel: ProficiencyLevel,
    val verifiedAt: LocalDateTime?,
    val evidenceSource: String? // Project ID, external credential reference etc.
)

enum class ProficiencyLevel {
    BEGINNER,
    INTERMEDIATE,
    ADVANCED
}

data class RoleMatch(
    val roleId: String,
    val roleName: String,
    val matchScore: Float,
    val matchedCapabilities: List<String>
)

// ─────────────────────────────────────────────
// VEI — VERIFIED EMPLOYABILITY INDEX
// Assumed to be a universal score, not tied to a specific role
// ─────────────────────────────────────────────

data class VeiScore(
    val overallScore: Float,
    val calculatedAt: LocalDateTime,
    val expiresAt: LocalDate,
    val dimensions: VeiDimensions
)

data class VeiDimensions(
    val employerReadiness: Float,
    val industryAlignment: Float,
    val collaboration: Float,
    val executionConsistency: Float,
    val professionalMaturity: Float
)

// ─────────────────────────────────────────────
// SCORE HISTORY
// User-facing only — personal growth tracking, not shown to employers
// Preserved so Jordan can see how her capability has grown over time
// ─────────────────────────────────────────────

data class ScoreSnapshot(
    val snapshotId: String,
    val takenAt: LocalDateTime,
    val vciOverall: Float?,
    val veiOverall: Float?,
    val gafiLevel: GafiLevel?,
    val triggerReason: String             // e.g. "Reassessment", "New project verified", "Skill added"
)

// ─────────────────────────────────────────────
// COMMUNITY PROFILE
// Social layer sitting on top of the DHP
// Kept minimal in scope — connection, visibility, and engagement signals only
// ─────────────────────────────────────────────

data class CommunityProfile(
    val userId: String,
    val joinedAt: LocalDateTime,
    val memberHandle: String,             // Community-facing display name
    val isVisibleInDirectory: Boolean,    // User controls their own discoverability
    val connections: List<MemberConnection>,
    val eventsAttended: List<String>,     // Event IDs
    val resourcesAccessed: List<String>   // Resource IDs
)

data class MemberConnection(
    val connectedUserId: String,
    val connectionType: ConnectionType,
    val connectedAt: LocalDateTime
)

enum class ConnectionType {
    PEER,
    MENTOR,
    EMPLOYER
}