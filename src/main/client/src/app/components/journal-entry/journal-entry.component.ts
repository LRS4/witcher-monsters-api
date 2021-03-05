import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-journal-entry',
  templateUrl: './journal-entry.component.html',
  styleUrls: ['./journal-entry.component.less']
})
export class JournalEntryComponent implements OnInit {

  public selectedMonster: any;

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.dataService.selectedMonster.subscribe(selectedMonster => {
      return this.selectedMonster = selectedMonster;
    });
  }

}
