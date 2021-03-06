import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-vulnerabilities',
  templateUrl: './vulnerabilities.component.html',
  styleUrls: ['./vulnerabilities.component.less']
})
export class VulnerabilitiesComponent implements OnInit {

  public selectedMonster: any;

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.dataService.selectedMonster.subscribe(selectedMonster => {
      return this.selectedMonster = selectedMonster;
    });
  }

}
