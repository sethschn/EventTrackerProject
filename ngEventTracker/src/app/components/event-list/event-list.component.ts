import { EventService } from './../../services/event.service';
import { Component, OnInit } from '@angular/core';
import { Tracker } from 'src/app/model/tracker';
import { Router, ActivatedRoute } from '@angular/router';
import { Emotion } from 'src/app/model/emotion';
import { EmotionService } from 'src/app/services/emotion.service';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit {

  events: Tracker[] = [];
  emotions: Emotion[] = [];
  newEvent = new Tracker();
  emotionId = null;
  selectedEvent = null;
  selected: number = 1;
  editSelectedID: number = 0;
  editEvent = null;
  constructor(private eventService: EventService,private emotionService: EmotionService, private router: Router, private currentRoute: ActivatedRoute ) { }

  ngOnInit(): void {
    this.reload();
    this.loadEmotions();
  }

  selectOption(id: number) {
    //getted from event
    //console.log(id);
    //this.selected = id;
    //getted from binding
    //console.log(this.selected)
  }

  reload(){
    this.eventService.index().subscribe(
      data => {
        console.log("**load Events Success**");
        //console.log(data);
        this.events = data;
      },
      bad => {
        //this.router.navigateByUrl('/login')
        console.error('EventListComponent.reload(): error retrieving todo list');
       console.error(bad);

      }
    );
  }

  loadEmotions(){
    this.emotionService.index().subscribe(
      data => {
        console.log("**loadEmotions Success**");
        //console.log(data);
        this.emotions = data;
      },
      bad => {
        //this.router.navigateByUrl('/login')
        console.error('EventListComponent.loadEmotions(): error retrieving todo list');
       console.error(bad);
      }
    );
  }

  displaySingleEvent(event: Tracker){
    console.log("Display Single Event");
    console.log(event);
    this.selectedEvent = event;
  }

  displayTable(){
    this.selectedEvent = null;
  }

  setEditEvent(){
    this.editEvent = Object.assign({}, this.selectedEvent);
  }


  addEvent(event: Tracker, emotionId: number){
    console.log(event);
    console.log("Emotion ID: "+emotionId);
    this.eventService.create(event,emotionId).subscribe(
      good => {
        this.reload();
        this.newEvent = new Tracker()
      },
      bad => {
        console.error('eventlistcomponent.addTodo(): error adding todo');
        console.error(bad);
      }
    )
  }

  deleteEvent(id: number){
    this.eventService.destroy(id).subscribe(
      yay => {
        this.reload();
      },
      boo => {
        console.error('eventListComponent.deleteTodo(): error');
        console.error(boo);

      }
    )
    this.reload();
    //this.todos = this.todoService.index();
  }

  updateEvent(event: Tracker, emotionId: number){
    console.log("Updating Event");
    this.selectedEvent = event;
    this.emotions.forEach((emotion)=>{
      if (emotion.id == emotionId){
        this.selectedEvent.emotion = emotion;
      }
    });
    this.eventService.update(event).subscribe(
      yes => {
        this.reload();
        this.editEvent = null;
      },
      no => {
        console.error('eventListComponent.updateTodo(): error');
        console.error(no);

      }
    );
    //this.todos = this.todoService.index();
  }


}
