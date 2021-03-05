import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-portrait',
  templateUrl: './portrait.component.html',
  styleUrls: ['./portrait.component.less']
})
export class PortraitComponent implements OnInit {

  public selectedMonster: any;

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.dataService.selectedMonster.subscribe(selectedMonster => {
      return this.selectedMonster = selectedMonster;
    });
  }

}
