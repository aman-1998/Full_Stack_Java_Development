package personal.learning.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity(name = "instructor_detail")
@Table(name = "instructor_detail")
public class InstructorDetail {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_detail_generator")
	@SequenceGenerator(name = "instructor_detail_generator", sequenceName = "instructor_detail_sequence", allocationSize = 1)
	private int id;
	
	@Column(name = "youtube_channel", unique = true)
	private String youtubeChannel;
	
	@Column(name = "channel_description")
	private String channelDescription;
	
	@Column(name = "no_of_subscriber")
	@Min(value = 0)
	private int noOfSubscriber;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;
	
	public InstructorDetail() {}
	
	public InstructorDetail(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getYoutubeChannel() {
		return youtubeChannel;
	}
	
	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}
	
	public String getChannelDescription() {
		return channelDescription;
	}
	
	public void setChannelDescription(String channelDescription) {
		this.channelDescription = channelDescription;
	}

	public int getNoOfSubscriber() {
		return noOfSubscriber;
	}

	public void setNoOfSubscriber(int noOfSubscriber) {
		this.noOfSubscriber = noOfSubscriber;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", channelDescription="
				+ channelDescription + ", noOfSubscriber=" + noOfSubscriber + "]";
	}
	
}
