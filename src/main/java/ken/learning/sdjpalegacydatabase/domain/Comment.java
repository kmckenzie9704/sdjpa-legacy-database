package ken.learning.sdjpalegacydatabase.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;
import java.util.Set;

@Table(name = "wp_comments", indexes = {
        @Index(name = "comment_post_id", columnList = "comment_post_id"),
        @Index(name = "comment_approved_date_gmt", columnList =  "comment_approved, comment_date_gmt"),
        @Index(name = "comment_date_gmt", columnList = "comment_date_gmt"),
        @Index(name = "comment_parent", columnList =  "comment_parent"),
        @Index(name = "comment_author_email", columnList =  "comment_author_email")
})
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_ID")
    private Long id;


    @NotNull
    @Column(name = "comment_post_ID")
    private Long postId;

    @Size(max = 255)
    @NotNull
    @Column(name = "comment_author", columnDefinition = "tinytext")
    private String commentAuthor;

    @Size(max = 100)
    @Email
    @NotNull
    @Column(name = "comment_author_email", length = 100)
    private String authorEmail;

    @Size(max = 200)
    @NotNull
    @Column(name = "comment_author_url", length = 200)
    private String authorUrl;

    @Size(max = 100)
    @NotNull
    @Column(name = "comment_author_ip", length = 100)
    private String authorIp;

    @NotNull
    @Column(name = "comment_date")
    private Timestamp commentDate;

    @NotNull
    @Column(name = "comment_date_gmt")
    private Timestamp commentDateGmt;

    @Lob
    @NotNull
    @Column(name = "comment_content", columnDefinition = "text")
    private String commentContent;

    @NotNull
    @Column(name = "comment_karma")
    private Integer commentKarma;

    @Size(max = 20)
    @NotNull
    @Column(name = "comment_approved", length = 20)
    private String commentApproved;

    @Size(max = 255)
    @NotNull
    @Column(name = "comment_agent", length = 255)
    private String commentAgent;

    @Size(max = 20)
    @NotNull
    @Column(name = "comment_type", length = 20)
    private String commentType;

    @NotNull
    @Column(name = "comment_parent")
    private Long commentParent;

    @OneToMany(mappedBy = "comment")
    private Set<CommentMeta> commentMetaSet;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getAuthorIp() {
        return authorIp;
    }

    public void setAuthorIp(String authorIp) {
        this.authorIp = authorIp;
    }

    public Timestamp getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Timestamp commentDate) {
        this.commentDate = commentDate;
    }

    public Timestamp getCommentDateGmt() {
        return commentDateGmt;
    }

    public void setCommentDateGmt(Timestamp commentDateGmt) {
        this.commentDateGmt = commentDateGmt;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getCommentKarma() {
        return commentKarma;
    }

    public void setCommentKarma(Integer commentKarma) {
        this.commentKarma = commentKarma;
    }

    public String getCommentApproved() {
        return commentApproved;
    }

    public void setCommentApproved(String commentApproved) {
        this.commentApproved = commentApproved;
    }

    public String getCommentAgent() {
        return commentAgent;
    }

    public void setCommentAgent(String commentAgent) {
        this.commentAgent = commentAgent;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    public Long getCommentParent() {
        return commentParent;
    }

    public void setCommentParent(Long commentParent) {
        this.commentParent = commentParent;
    }

    public Set<CommentMeta> getCommentMetaSet() {
        return commentMetaSet;
    }

    public void setCommentMetaSet(Set<CommentMeta> commentMetaSet) {
        this.commentMetaSet = commentMetaSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
